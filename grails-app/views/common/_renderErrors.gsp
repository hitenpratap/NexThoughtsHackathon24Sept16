<g:if test="${flash.success}">
    <div class="col-lg-offset-1">
        <div class="alert row alert-success alert-dismissible alert-visible" role="alert">
            <button type="button" class="close" data-dismiss="alert"><span
                    aria-hidden="true">&times;</span><span
                    class="sr-only">Close</span></button>
            <i class="fa fa-check"></i> ${flash.success}
        </div>
    </div>
</g:if>

<g:elseif test="${flash.error}">
    <div class="col-lg-offset-1">
        <div class="alert row alert-danger alert-dismissible alert-visible" role="alert">
            <button type="button" class="close" data-dismiss="alert"><span
                    aria-hidden="true">&times;</span><span
                    class="sr-only">Close</span></button>
            <i class="fa fa-times-circle"></i> ${flash.error}
        </div>
    </div>
</g:elseif>

<g:elseif test="${flash.warning}">
    <div class="col-lg-offset-1">

        <div class="alert row alert-warning alert-dismissible alert-visible" role="alert">
            <button type="button" class="close" data-dismiss="alert"><span
                    aria-hidden="true">&times;</span><span
                    class="sr-only">Close</span></button>
            <i class="fa fa-warning"></i> ${flash.warning}
        </div>
    </div>
</g:elseif>

<g:elseif test="${flash.info}">
    <div class="col-lg-offset-1">
        <div class="alert row alert-info alert-dismissible alert-visible" role="alert">
            <button type="button" class="close" data-dismiss="alert"><span
                    aria-hidden="true">&times;</span><span
                    class="sr-only">Close</span></button>
            <i class="fa fa-info-circle"></i> ${flash.info}
        </div>
    </div>
</g:elseif>

<g:elseif test="${flash.message}">
    <div class="col-lg-offset-1">
        <div class="alert row alert-info alert-dismissible alert-visible" role="alert">
            <button type="button" class="close" data-dismiss="alert"><span
                    aria-hidden="true">&times;</span><span
                    class="sr-only">Close</span></button>
            <i class="fa fa-envelope"></i> ${flash.message}
        </div>
    </div>
</g:elseif>

<g:elseif test="${beanInstance}">
    <g:if test="${beanInstance?.hasErrors()}">
        <div class="col-lg-offset-1">
            <div class="alert row alert-danger" role="alert">
                <strong><i class="fa fa-times-circle"></i> Please resolve following errors first:</strong>
                <g:renderErrors bean="${beanInstance}"/>
            </div>
        </div>
    </g:if>
</g:elseif>

<script>
    function closeAlert() {
        console.log("*************     Auto closing Alert Message  ------------------------")
        $(".alert-dismissible").alert('close')
    }

    //    setTimeout(function(){ closeAlert()},10000);
</script>