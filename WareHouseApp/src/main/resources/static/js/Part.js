 $(document).ready(function () {
            //1.hide the error section
               $("#partcodeError").hide();
              
               $("#basecostError").hide();
               $("#CurrencyError").hide();
               $("#DescriptionError").hide();
               $("#uomError").hide();
               $("#dimError").hide();
               $("#salesError").hide();
               
            
            //2.declaring a variable
            var partcodeError=false;
            var basecostError=false;
            var CurrencyError=false;
            var DescriptionError=false;
            var uomError=false;
            var salesError=false;
            var dimError=false;
            
            //3.declare a function
            function validate_dim(){
                var val=$("#partlen").val();
                var val1=$("#partht").val();
                var val2=$("#partwid").val();
                if((val=="" && val1=="" && val2=="")){
                    $("#dimError").show();
                    $("#dimError").html("Please <b> set any value </b> code");
                    $("#dimError").css("color","red");
                    dimError=false;
                }
                else if(val==""){
                    $("#dimError").show();
                    $("#dimError").html("Please <b> set partlen </b> code");
                    $("#dimError").css("color","red");
                    dimError=false; 
                }else if(val1==""){
                    $("#dimError").show();
                    $("#dimError").html("Please <b> set part height </b> code");
                    $("#dimError").css("color","red");
                    dimError=false;
                }else if(val2==""){
                    $("#dimError").show();
                    $("#dimError").html("Please <b> set part width </b> code");
                    $("#dimError").css("color","red");
                    dimError=false;
                }else{
                    $("#dimError").hide();
                    dimError=true;
                }
                return dimError;
            }
            
            function validate_partcode(){
                var val=$("#partcode").val();
                var fmt=/[A-Z0-9\-]{4}/;
                if(val==""){
                    $("#partcodeError").show();
                    $("#partcodeError").html("Please <b> set the </b> code");
                    $("#partcodeError").css("color","red");
                    partcodeError=false;
                }
                else if(!fmt.test(val)){
                    $("#partcodeError").show();
                    $("#partcodeError").html("Please <b> set the valid </b> code");
                    $("#partcodeError").css("color","green");
                    partcodeError=false;
                }
                else{
                    $("#partcodeError").hide();
                    partcodeError=true;
                }
                return partcodeError;
            }

            function validate_basecost(){
                var val=$("#basecost").val();
                if(val==""){
                    $("#basecostError").show();
                    $("#basecostError").html("Please <b> set the </b> cost");
                    $("#basecostError").css("color","red");
                    basecostError=false;
                }else{
                    $("#basecostError").hide();
                    
                    
                    basecostError=true;
                }
                return basecostError;
            }

            function validate_Currency(){
                var val=$("#Currency").val();
                if(val==""){
                    $("#CurrencyError").show();
                    $("#CurrencyError").html("Please <b> set the </b> currency");
                    $("#CurrencyError").css("color","red");
                    CurrencyError=false;

                }else{
                    $("#CurrencyError").hide();
                    CurrencyError=true;

                }
                return CurrencyError;
            }
            
            function validate_Description(){
                var val=$("#Description").val();
                var exp=/[A-Za-z0-9\-\.\s]{4,125}/;
                if(val==""){
                    $("#DescriptionError").show();
                    $("#DescriptionError").html("Please <b> Enter some </b> Text");
                    $("#DescriptionError").css("color","red");
                    DescriptionError=false;

                }else if(!exp.test(val)){
                    $("#DescriptionError").show();
                    $("#DescriptionError").html("Please <b> Enter some valid</b> Text");
                    $("#DescriptionError").css("color","green");
                    DescriptionError=false;
                }else{
                    $("#DescriptionError").hide();
                    DescriptionError=true;
                }

                return DescriptionError;
                
            }

            function validate_uom(){
                var val=$("#uom").val();
                if(val==""){
                    $("#uomError").show();
                    $("#uomError").html("Please <b> Select an item </b> ");
                    $("#uomError").css("color","red");
                    uomError=false;
                }else{
                    $("#uomError").hide();
                    uomError=true;
                    
                }

                return uomError;
            }
            
          function validate_sales(){
          var val=$("#sale").val();
          if(val==""){
                    $("#salesError").show();
                    $("#salesError").html("Please <b> Select an item </b> ");
                    $("#salesError").css("color","red");
                    salesError=false;
          }else{
                $("#salesError").hide();
                 salesError=true;
          }
          return salesError;
      }
          

           
            
            //4.linking the function
               $("#partcode").keyup(function(){
                   validate_partcode();
               });

               $("#basecost").keyup(function(){
                   validate_basecost();
               });

               $("#Currency").change(function(){
                   validate_Currency();
               });

               $("#Description").keyup(function(){
                   validate_Description();
               });

               $("#uom").change(function(){
                   validate_uom();
               });

               $("#partwid").keyup(function(){
                   validate_dim();
               });

               $("#partlen").keyup(function(){
                   validate_dim();
               });

               $("#partht").keyup(function(){
                   validate_dim();
               });
               
              $("#sale").change(function(){
              validate_sales();
              });
                    
            //5.submitting to the server
            $("#PartRegForm").submit(function(){
                validate_partcode();
                validate_basecost();
                validate_Currency();
                validate_Description();
                validate_uom();
                validate_dim();
                validate_sales();
                

                if( partcodeError && basecostError && CurrencyError && DescriptionError 
                                  && dimError&& uomError && salesError){
                    return true;
                }else{
                    return false;
                }
            })
        });