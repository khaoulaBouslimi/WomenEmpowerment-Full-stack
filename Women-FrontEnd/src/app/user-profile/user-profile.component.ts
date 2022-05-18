import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  id : any;
  user : any;
  constructor(private token : TokenStorageService , 
               private userService : UserService , 
               private router : Router,
               private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userService.get(this.id).subscribe( data => {
      this.user = data;
      console.log(data)
    });
  }

  updateProfile(id : number){
    this.router.navigate(['update-user', this.id]);
  }

  



}
