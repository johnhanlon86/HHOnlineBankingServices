// You must run the URI... 
// http://localhost:49000/api/bank/createpastcustomers ...to create the resources
// prior to running the index.html file 
// Allow Blocked content... if you see that warning in the browser


$(document).ready(function() {
    $.ajax({
        url: "http://localhost:49000/api/bank/getaccountsortcode/0/41324/darylhowe"
    }).then(function(data) {
       $('.resp-sortCode').append(data);
       console.log(data)
    });
});




