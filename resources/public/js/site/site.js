site_sign_out = function() {
    $.removeCookie('pm[email]');
    $.removeCookie('pm[password]');
    window.location = "/sign-out";
};

$('#signin').submit(function() {
    var expires_day = 365;
    $.cookie('pm[email]', $('#email').val(), { expires: expires_day });
    $.cookie('pm[password]', $('#password').val(), { expires: expires_day });
    return true;
});

// $(document).ready(function() {
//     $('#email').val($.cookie('pm[email]'));
//     $('#password').val($.cookie('pm[password]'));
//     if ($('#email').val() != null && $('#email').val() != '' &&
//         $('#password').val() != null && $('#password').val() != '') {
//         $('#signin').submit();
//     }
// });

// $(document).ready(function() {
//     $('#email').val($.cookie('pm[email]'));
//     $('#password').val($.cookie('pm[password]'));
//     if ($('#email').val() != null && $('#email').val() != '' &&
//         $('#password').val() != null && $('#password').val() != '') {
//         $('#signin').submit();
//     }
// });

$('#save').submit(function() {
    // do additional validation here.
    return true;
});
