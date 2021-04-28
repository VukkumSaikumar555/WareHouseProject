 $(document).ready(function(){
            //1.hiding error section.
            $("#OrderCodeError").hide();
            $("#CodeError").hide();
            $("#vendorError").hide();
            $("#refNumberError").hide();
            $("#qtycheckError").hide();
            $("#statusError").hide();
            $("#descriptionError").hide();
            
            //2.declare variable
            var OrderCodeError=false;
            var CodeError=false;
            var vendorError=false;
            var refNumberError=false;
            var qtycheckError=false;
            var statusError=false;
            var descriptionError=false;

            //3.validating a function
            function validate_ordercode(){
                var val=$("#OrderCode").val();
                var exp = /^[A-Z0-9\.\-]{4,12}$/
                if(val==""){
                    $("#OrderCodeError").show();
                    $("#OrderCodeError").html("Please <b> Enter </b> a text");
                    $("#OrderCodeError").css('color','red');
                    OrderCodeError=false;
                }else if(!exp.test(val)){
                    $("#OrderCodeError").show();
                    $("#OrderCodeError").html("Please <b> Enter  valid</b> a text");
                    $("#OrderCodeError").css('color','green');
                    OrderCodeError=false;
                }
                else{
                    $("#OrderCodeError").hide();
                    OrderCodeError=true;
                }
                return OrderCodeError;
            }

            function validate_CodeError(){
                var val=$("#code").val();
                if(val==" "){
                    $("#CodeError").show();
                    $("#CodeError").html("Please <b> Select </b> a Value");
                    $("#CodeError").css('color','red');
                    CodeError=false;
                }else{
                    $("#CodeError").hide();
                    CodeError=true;
                }
                return CodeError;
            }
                
            function validate_vendorError(){
                var val=$("#vendor").val();
                if(val==""){
                    $("#vendorError").show();
                    $("#vendorError").html("Please <b> Select </b> a Value");
                    $("#vendorError").css('color','red');
                    vendorError=false;
                }else{
                    $("#vendorError").hide();
                    vendorError=true;
                }
                return vendorError;
            }

            function validate_refNumberError(){
                var val=$("#refNumber").val();
                var exp=/[A-Z0-9\.\-]{5,10}/;
                if(val==""){
                    $("#refNumberError").show();
                    $("#refNumberError").html("Please <b> Enter </b> a Text");
                    $("#refNumberError").css('color','red');
                    refNumberError=false;
                }else if(!exp.test(val)){
                    $("#refNumberError").show();
                    $("#refNumberError").html("Please <b> Enter a valid</b> a Text");
                    $("#refNumberError").css('color','green');
                    refNumberError=false;
                }else{
                    $("#refNumberError").hide();
                    refNumberError=true;
                }
                return refNumberError;
            }
            
            function validate_qtycheckError(){
                var val=$('[name="qtycheck"]:checked').length;
                if(val==0){
                    $("#qtycheckError").show();
                    $("#qtycheckError").html("Please <b> select a </b> a button");
                    $("#qtycheckError").css('color','red');
                    qtycheckError=false;
                }else{
                    $("#qtycheckError").hide();
                    qtycheckError=true;
                }
                return qtycheckError;
            }
             
            function validate_statusError(){
                var val=$("#status").val();
                if(val==""){
                    $("#statusError").show();
                    $("#statusError").html("Please <b> Enter a </b> Text");
                    $("#statusError").css('color','red');
                    statusError=false;
                }else{
                    $("#statusError").hide();
                    statusError=true;
                }
                return statusError;
            }

            function validate_descriptionError(){
                var val=$("#description").val();
                var exp=/[A-Za-z0-9\.\,\s\-]{5,125}/;
                if(val==""){
                    $("#descriptionError").show();
                    $("#descriptionError").html("Please <b> Enter Some </b> Text");
                    $("#descriptionError").css('color','red');
                    descriptionError=false;
                }else if(!exp.test(val)){
                    $("#descriptionError").show();
                    $("#descriptionError").html("Please <b> Enter Some valid </b> Text");
                    $("#descriptionError").css('color','green');
                    descriptionError=false;
                }else{
                    $("#descriptionError").hide();
                    descriptionError=true;
                }
                return descriptionError;
            }

            //4.linking with events
            $("#OrderCode").keyup(function(){
                validate_ordercode();
            });

            $("#code").change(function(){
                validate_CodeError();
            });

            $("#vendor").change(function(){
                validate_vendorError();
            });

            $("#refNumber").keyup(function(){
                validate_refNumberError();
            });

            $('[name="qtycheck"]').change(function(){
                validate_qtycheckError();
            });

            $("#status").keyup(function(){
                validate_statusError();
            });

            $("#description").keyup(function(){
                validate_descriptionError();
            })

            //5.submit the form
            $("#idpurchase").submit(function(){
                validate_ordercode();
                validate_CodeError();
                validate_vendorError();
                validate_refNumberError();
                validate_qtycheckError();
                validate_statusError();
                validate_descriptionError();
                
                if(OrderCodeError && CodeError&& vendorError && refNumberError &&
                qtycheckError && statusError && descriptionError)
                   return true;
                else
                   return false;   
            });

        });