import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BlogService } from '../blog.service';
import { SubSink } from 'subsink';
import { Post } from '../models/post';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  private subs = new SubSink();
  newPost : Post ={
    id: undefined,
    title: '',
    publication_txt: '',
    createdAt: Date.now()
  };
  posts !: any;

  currentPost : Post = {
    id: undefined,
    title: '',
    publication_txt: '',
    createdAt: ''
  };
  currentIndex = -1;
  title = '';


  constructor(private postService : BlogService , private router : Router) { }

  ngOnInit(): void {
    this.retrievePosts();
  }

  retrievePosts(): void {
    this.postService.getAllPosts()
      .subscribe(
        data => {
          this.posts = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  postDetails(id : number){
      this.router.navigate(['blog-post' , id]);
  }

 

  setActivePost(post: any, index: number): void {
    this.currentPost = post;
    this.currentIndex = index;
  }

 


 publishPost(post: any) {
  const data = {
    title: this.newPost.title,
    publication_txt: this.newPost.publication_txt,
  };
  this.subs.sink = this.postService.add(data).subscribe(
     res => {
        //refresh post list
        console.log(res);
     },
     err => {
        //alert("An error occured while publishing a post");
        console.log(err);
     }
  )
}


}
