import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FacebookLoginProvider, SocialAuthService } from 'angularx-social-login';

@Component({
  selector: 'app-facebook-login',
  templateUrl: './facebook-login.component.html',
  styleUrls: ['./facebook-login.component.css']
})
export class FacebookLoginComponent implements OnInit {
  
  title = 'angularbootstrap';
  public user: any;
  public loggedIn!: boolean;
  constructor(private authService: SocialAuthService) {}
  //Logion
   signInWithFB(): void {
    this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
  }
  // Logout Function
  signOut(): void {
    this.authService.signOut();
  }
  ngOnInit() {
    //Get User Data
    this.authService.authState.subscribe((user) => {
      this.user = user;
 
      this.loggedIn = user != null;
    });
   
  }
}
