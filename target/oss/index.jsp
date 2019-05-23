<%--
  Created by IntelliJ IDEA.
  User: guohaodong
  Date: 2/28/19
  Time: 11:12 PM
  To change this template use File | Settings | File Templates..
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

  <script>
      $(function(){
          $("#signin").click(function(){
              var email = $("#email").val();
              console.log(email);

              var password = $("#password").val();
              console.log(password);
              var json = {
                  "email":email,
                  "password": password
              };

              $.ajax({
                  type: "post",

                  // todo
                  url:
                      "http://localhost:8080/HuaWeibei_war_exploded/user/register.form",
                  data:json,
                  dataType: "json",
                  success: function (response) {
                      console.log(response);
                  },
                  error:function (xhr) {
                      console.log(xhr.status)
                  }
              });
          })
      })

      $(function () {
          $("#register").click(function () {
              // var userEmail = $("#userEmail").val();
              // var password = $("#password").val();

              var testUrl = "http://localhost:8080/HuaWeibei_war_exploded/user/register.form";
              var json =
                  {
                      "email": "7788",
                      "password": "567"
                  };
              $.ajax({
                  "url": testUrl,
                  "type":"post",
                  "data" : JSON.stringify(json),
                  "dataType":"json",
                  "contentType":"application/json;charset=utf-8",
                  "success":function(date){
                      var string = JSON.stringify(date);
                      // alert(string);
                      $("#out").text(string);
                      alert("注册成功！");

                  },
                  "error":function () {
                      // alert("connection load failure");
                  }
              });
          })
      })
  </script>
</head>
<body>
<p>
  <input type="email" id="email">
  <input type="password" name="" id="password">
  <button type="submit" id="signin">test</button>
  <button type="submit" id="register">register</button>
  <span id="out"></span></p>

</body>
</html>
