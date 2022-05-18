import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id ! : number;
  user : User={
    id: 0,
    username: '',
    email: '',
    password: '',
    genre : '',
    age: 0,
    dob : new Date(),
    adresse: '',
    phone: ''
  };

  constructor(private userService : UserService ,
              private route : ActivatedRoute,
              private router : Router
    ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userService.get(this.id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.userService.update(this.id, this.user).subscribe( data =>{
      console.log(data);
      this.reloadPage();
    }
    , error => console.log(error));
  }

  reloadPage(){
    this.router.navigate(['update-user', this.id]);
  }

}
