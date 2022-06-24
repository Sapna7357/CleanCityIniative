$(document).ready(function() {
   $("#submit").click(function(){
    let email_check = $("#email").val();
    let password_check = $("#password").val();
    let confirmPassword_check = $("#confirm_password").val();
    let fname_check = $("#fname").val();
    let uname_check = $("#uname").val();
    var checkValidations = true;
  // regular expressions for validations
   var email_match = /^[A-Za-z_]{3,}[._]*[a-zA-z0-9]*@[A-Za-z]{3,}[.]{1}[A-Za-z.]{2,6}$/;
    var fname = /^[A-Za-z]{3,30}$/;
    var uname = /^[A-Za-z]{3,30}$/;
    var password = /^\S*(?=\S{6,})(?=\S*\d)(?=\S*[A-Z])(?=\S*[a-z])(?=\S*[!@#$%^&*? ])\S*$/;

    //// validate the email entry with a regular expression
    if (email_check != "") {
      if (email_match.test(email_check)) {
        $(".email-error").text("");
      } else {
        $(".email-error").text(" ** Enter Valid Mail");
        $("span").css({"color": "red", "font-size": "x-small" , "font-weight" : "bold"});
        checkValidations = false;
      }
    } else {
      $(".email-error").text(" ** This field is required");
      checkValidations = false;
    }
    //valiadte full name entry with regular expression
    if (fname_check != "") {
      if (fname.test(fname_check)) {
        $(".fname-error").text("");
      } else {
        $(".fname-error").text(" ** Full Name contains only characters");
        checkValidations = false;
      }
    } else {
      $(".fname-error").text("** This field is required");
      $("span").css({"color": "red", "font-size": "x-small" , "font-weight" : "bold"});
      checkValidations = false;
    }
    //valiadte last name entry with regular expression
    if (uname_check != "") {
      if (uname.test(uname_check)) {
        $(".uname-error").text("");
      } else {
        $(".uname-error").text("** username Name can contains Characters");
        $("span").css({"color": "red", "font-size": "x-small" , "font-weight" : "bold"});
        checkValidations = false;
      }
    } else {
      $(".uname-error").text("** This field is required");
      checkValidations = false;
    }
    if (password_check!= "") {
        if (password.test(password_check)) {
          $(".password-error").text("");
        } else {
          $(".password-error").text("** your password must at least 6 characters, one upper case , one lower case and one special character");
          $("span").css({"color": "red", "font-size": "x-small" , "font-weight" : "bold"});
          checkValidations = false;
        }
      } else {
        $(".password-error").text("** This field is required");
        
        checkValidations = false;
      }
    if (confirmPassword_check!= "") {
        if (confirmPassword_check == password_check ) {
          $(".confirm-error").text("");
        } else {
          $(".confirm-error").text("** your passwords should be equal");
          checkValidations = false;
        }
      } else {
        $(".confirm-error").text("** This field is required");
        
        checkValidations = false;
      }
    if(checkValidations = true){
		$.ajax({
			type: 'POST',
			url : 'registerForm',
			data: {"fname": fname_check, "uname" : uname_check , "email" : email_check, "password" :password_check,"confirm_password" : confirmPassword_check}
		})	
	}
    
      });
   
});
