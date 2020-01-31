package com.task.task.currentwheather.entities

data class ApiResponseBody<T> (var main:T? ,var cod:Int? ,var message:String?)