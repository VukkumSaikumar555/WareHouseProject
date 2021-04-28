 $(document).ready(function () {

            //1.hide error sections
            $("#emailError").hide();
            $("#usertypeError").hide();
            $("#usercodeError").hide();
            $("#contactError").hide();
            $("#useridError").hide();

            $("#ifOtherRow").hide();

            //2.assigning variables
            var emailError = false;
            var usertypeError = false;
            var usercodeError = false;
            var contactError = false;
            var useridError = false;

            //3.define function validations
              function validate_email() {
                    var val = $("#email").val();
                    var exp = /^[A-Za-z0-9\.\-\_]+\@[a-z\.]+\.[a-z\.]{2,12}$/

                    if (val=="") {
                        $("#emailError").show();
                        $("#emailError").html("Please enter <b>Email id </b>");
                        $("#emailError").css('color', 'red');
                        emailError = false;
                    } else if (!exp.test(val)) {
                        $("#emailError").show();
                        $("#emailError").html("Please enter <b> valid Email id </b>");
                        $("#emailError").css('color', 'green');
                        emailError = false;
                    } else {
                        $("#emailError").hide();

                        emailError = true;
                    }
                    return emailError;
                }

                function validate_usertype(){
                    var len=$('input[type="radio"][name="usertype"]:checked').length;
                    if(len == 0){
                        $("#usertypeError").show();
                        $("#usertypeError").html("Please <b> Select an </b> option");
                        $("#usertypeError").css('color','red');
                        usertypeError=false;
                    }
                    else{
                        $("#usertypeError").hide();
                        usertypeError=true;
                    }
                    return usertypeError;
                }
                 
                 function validate_code(){
                     var val=$("#usercode").val();
                     var exp=/^[A-Z0-9\.\-]{4,15}$/;
                     if(val==""){
                         $("#usercodeError").show();
                         $("#usercodeError").html("Please <b> enter </b> code");
                         $("#usercodeError").css('color','red');
                         usercodeError=false;
                     }else if(!exp.test(val)){
                         $("#usercodeError").show();
                         $("#usercodeError").html("Please <b> Enter Valid</b> code");
                         $("#usercodeError").css('color','cyan');
                         usercodeError=false;
                     }
                     else{
                        $("#usercodeError").hide();
                        usercodeError=true;
                     }
                     return usercodeError;
                 }
                  
                 function validate_contactError(){
                     var len=$("#contact").val();
                     var exp=/^[A-Z0-9a-z\.\-]{5,20}/;
                     if(len==""){
                         $("#contactError").show();
                         $("#contactError").html("Please enter <b> some</b> text");
                         $("#contactError").css('color','red');
                         contactError=false;

                     }else if(!exp.test(len)){
                         $("#contactError").show();
                         $("#contactError").html("Please enter <b>  text between 5-20 chars</b>");
                         $("#contactError").css('color','green');
                         contactError=false;
                     }else{
                         $("#contactError").hide();
                
                         contactError=true;
                     }
                     return contactError;
                 }

                 function Autofill(){
                    var val=$('input[type="radio"][name="usertype"]:checked').val();
                    if(val=="Vendor"){
                        $("#userfor").val('Purchase');
                    }else if(val=="Customer"){
                        $("#userfor").val('Sale');
                    }   
                 }

                 function validate_userid(){
                     var val=$("#userid").val();
                     if(val==""){
                         $("#useridError").show();
                         $("#useridError").html("Please select <b> one </b> option");
                         $("#useridError").css('color','red');
                         useridError=false;
                     }else{
                         if(val=="OTHER"){
                             $("#ifOtherRow").show();
                         }else{
                            $("#userif").val("");
                            $("#ifOtherRow").hide();
                         }
                         $("#useridError").hide();
                         
                         useridError=true;
                     }
                     return useridError;
                 }
                
                 
                //4.link with events
                $("#email").keyup(function () {
                    validate_email();
                });

                $('input[type="radio"][name="usertype"]').change(function(){
                    validate_usertype();
                });
                 
                $("#usercode").keyup(function(){
                    validate_code();
                });

                $("#contact").keyup(function(){
                    validate_contactError();
                });

                $('input[type="radio"][name="usertype"]').change(function(){
                   Autofill();
                });

                $("#userid").change(function(){
                     validate_userid();
                });

                //5.submit event
                $("#whuserform").submit(function () {
                    validate_email();
                    validate_usertype();
                    validate_code();
                    validate_contactError();
                    validate_userid();

                    if (emailError && usertypeError && usercodeError && contactError && useridError) {
                        return true;
                    } 
                    else {
                        return false;
                    }
                });
            });
