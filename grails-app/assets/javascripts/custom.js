function notifySuccess(msg) {
    toastr.success(msg);
}

function notifyError(msg) {
    toastr.error(msg);
}

function notifyInfo(msg) {
    toastr.info(msg);
}

function notifyWarning(msg) {
    toastr.warning(msg);
}
$('.datepicker').datepicker({
    weekStart: 1
});