import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FacebookLoginProvider } from 'angularx-social-login';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  protected aFormGroup!: FormGroup;
  constructor(private authService: AuthService, private tokenStorage: TokenStorageService,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;

    }
    this.aFormGroup = this.formBuilder.group({
      recaptcha: ['', Validators.required]
    });
  }

  onSubmit(): void {
    const { username, password } = this.form;

    this.authService.login(username, password).subscribe(
      (      data: { accessToken: any; }) => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
      },
      (      err: { error: { message: string; }; }) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
 

  reloadPage(): void {
    window.location.href = "/";
  }
  siteKey:string='6LcvUbwfAAAAABWz8VDtP-7A1eebEKQW9qYFcZfF';

}