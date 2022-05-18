import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BlogService } from '../blog.service';
import { Post } from '../models/post';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  newPost : Post ={
    id: undefined,
    title: '',
    publication_txt: '',
    createdAt: Date.now()
  };
  
  constructor(private postService : BlogService , private router : Router) { }

  ngOnInit(): void {
  }


  publishPost() {
    const data = {
      title: this.newPost.title,
      publication_txt: this.newPost.publication_txt,
    };
    this.postService.add(data).subscribe(
       res => {
          //refresh post list
          console.log(res);
          this.reloadPage();
       },
       err => {
          //alert("An error occured while publishing a post");
          console.log(err);
       }
    )
  }

  onSubmit(){
    console.log(this.newPost);
    this.publishPost();
  }

  reloadPage(){
    window.location.href = "/blog";
  }

}
