package com.example.demo.entities;

import java.util.List;

import lombok.Data;

@Data

public class AjaxResponseBody {

    String msg;
    List<User> result;

   

}
