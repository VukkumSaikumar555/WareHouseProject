// order method form validations 
 $(document).ready(function(){
    //hiding error messages                     
     $("#OrderModeError").hide();
     $("#OrderCodeError").hide();
     $("#OrderTypeError").hide();
     $("#orderAcptError").hide();
     $("#OrderDescError").hide();

    //declaring error variables
        var OrderModeError=false;
        var OrderCodeError=false;
        var OrderTypeError=false;
        var orderAcptError=false;
        var OrderDescError=false;

    //declaring a function validation
       function valid_OrderModeError(){
        var vl=$('[name="OrderMode"]:checked').length;
         if(vl==0){
           $("#OrderModeError").show();
           $("#OrderModeError").html("Please select any <b>check</b> box");
           $("#OrderModeError").css("color","red");
           OrderModeError=false;
         }else{
          $("#OrderModeError").hide();
          OrderModeError=true;
         }
         return OrderModeError;
       }

       function valid_OrderCodeError(){
                var val = $("#OrderCode").val();
                var exp = /^[A-Z0-9\.\-]{4,12}$/
                if(val == ""){
                  $("#OrderCodeError").show();
                  $("#OrderCodeError").html("Please select any <b>Text</b> ");
                  $("#OrderCodeError").css("color","red");
                  OrderCodeError=false;

                }
                else if(!exp.test(val)){
                  $("#OrderCodeError").show();
                  $("#OrderCodeError").html("Please Enter <b> Valid </b> Text");
                  $("#OrderCodeError").css("color","green");
                  OrderCodeError=false;
                }
                else {
                  $("#OrderCodeError").hide();
                  OrderCodeError=true;
                }
                return  OrderCodeError;
       }

       function valid_OrderTypeError(){
         var val=$("#OrderType").val();
         if(val==""){
           $("#OrderTypeError").show();
           $("#OrderTypeError").html("please select <b> one </b> option");
           $("#OrderTypeError").css('color','red');
            OrderTypeError=false;

         }else{
          $("#OrderTypeError").hide();
           OrderTypeError=true;
         }
           return OrderTypeError;
       }

       function valid_OrderAcptError(){
         var len=$('[name="orderAcpt"]:checked').length;
         if(len==0){
           $("#orderAcptError").show();
           $("#orderAcptError").html("Please Select <b> one</b> option");
           $("#orderAcptError").css('color','red');
           orderAcptError=false;

         }else{
          $("#orderAcptError").hide();
          orderAcptError=true;
         }

         return orderAcptError;
       }

       function valid_OrderDescError(){
         var val=$("#OrderDesc").val();
         var exp=/[A-Z0-9a-z\.\,\s]{5,125}/;
         if(val==' '){
           $("#OrderDescError").show();
           $("#OrderDescError").html("Please enter some <b> text </b>");
           $("#OrderDescError").css('color','red');
           OrderDescError=false;
         }else if(!exp.test(val)){
          $("#OrderDescError").show();
           $("#OrderDescError").html("Please enter valid <b> text </b>");
           $("#OrderDescError").css('color','green');
           OrderDescError=false;
         }else{
          $("#OrderDescError").hide();
          OrderDescError=true;
          
         }
         return OrderDescError;
       }
    //linking function to event
       $('[name="OrderMode"]').change(function(){
         valid_OrderModeError();
       })

       $("#OrderCode").keyup(function(){
         valid_OrderCodeError();
       })

       $("#OrderType").change(function(){
         valid_OrderTypeError();
       })
      
       $('[name="orderAcpt"]').change(function(){
         valid_OrderAcptError();
       })

       $("#OrderDesc").keyup(function(){
         valid_OrderDescError();
       })
       
    //submitting
    $("#orderform").submit(function(){
      valid_OrderModeError();
      valid_OrderCodeError();
      valid_OrderTypeError();
      valid_OrderAcptError();
      valid_OrderDescError();

      if(OrderModeError && OrderCodeError && OrderTypeError && orderAcptError && OrderDescError){
        return true;
      }
      else{
        return false;
      }
    })
  });