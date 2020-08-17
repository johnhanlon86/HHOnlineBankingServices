// You must run the URI... 
// http://localhost:49000/api/bank/createpastcustomers ...to create the resources
// prior to running the index.html file 
// Allow Blocked content... if you see that warning in the browser



$(document).ready(function() {
    $.ajax({
        url: "http://localhost:49000/api/bank/createpastcustomers"
    }).then(function(data) {
       $('.resp-id').append(data.firstName);
       $('.resp-isbn').append(data.secondName);
       $('.resp-publisher').append(data.emailAddress);
    });
});


function loadPastCustomersIntoMemory() {
  axios.get('http://localhost:49000/api/bank/createpastcustomers')
                    .then(function (response) {
                    document.getElementById('people').innerHTML = response.data.map(function (customer) {
                    return (
                            '<div class = "customerContainer">' +
                            '<div> First Name: ' + customer.firstName + '</div>' +
                            '<div> Second Name: ' + customer.secondName + '</div>'+
                            '<div> Id Number: ' + customer.customerID + '</div>'+
                            '<div> Email Address: ' + customer.emailAddress + '</div>' +
                            '<div> Password: ' + customer.password + '</div>' +
                            '<div> -------------- </div>' +
                            '</div>'
                            );
                            }).join('');
                            })
                            .catch(function (err) {
                            document.getElementById('people').innerHTML = '<li class="text-danger">' + err.message + '</li>';
                            });
}

function viewAllCustomers() {
  axios.get('http://localhost:49000/api/bank')
                    .then(function (response) {
                    document.getElementById('people').innerHTML = response.data.map(function (customer) {
                    return (
                            '<div class = "customerContainer">' +
                            '<div> First Name: ' + customer.firstName + '</div>' +
                            '<div> Second Name: ' + customer.secondName + '</div>'+
                            '<div> Id Number: ' + customer.customerID + '</div>'+
                            '<div> Email Address: ' + customer.emailAddress + '</div>' +
                            '<div> Password: ' + customer.password + '</div>' +
                            '<div> -------------- </div>' +
                            '</div>'
                            );
                            }).join('');
                            })
                            .catch(function (err) {
                            document.getElementById('people').innerHTML = '<li class="text-danger">' + err.message + '</li>';
                            });
}

function viewDarylAccount41324() {

axios.get('http://localhost:49000/api/bank/getaccountdetails/0/41324/darylhowe').then(resp => {
    document.getElementById('people').innerHTML = 
            '<div> Account Name: ' + resp.data.accountName + '</div>' +
            '<div> Account Number: ' + resp.data.accountNumber + '</div>' + 
            '<div> Sort Code: ' + resp.data.sortCode + '</div>' +
            '<div> Account Type: ' + resp.data.accountType + '</div>' + 
            '<div> Balance: ' + resp.data.balance + '</div>'  
});
}

function viewDarylAccountHistory83232() {

axios.get('http://localhost:49000/api/bank/getaccounthistory/0/83232/darylhowe')
                    .then(function (response) {
                    document.getElementById('people').innerHTML = response.data.map(function (transaction) {
                    return (
                            '<div class = "customerContainer">' +
                            '<div> Transaction Id: ' + transaction.transactionId + '</div>' +
                            '<div> Date: ' + transaction.transactionDate + '</div>' +
                            '<div> Description: ' + transaction.description + '</div>' +
                            '<div> Account Type: ' + transaction.accountType + '</div>' +
                            '<div> Amount: ' + transaction.transactionAmount + '</div>' +
                            '<div> Pre-Transaction Balance: ' + transaction.preTransactionBalance + '</div>' +
                            '<div> Post-Transaction Balance: ' + transaction.postTransactionBalance + '</div>' +
                            '<div> Status: ' + transaction.status + '</div>' +
                            '<div> Transaction Type: ' + transaction.transactionType + '</div>' +
                            '<div> -------------------------------- </div>' +
                            '</div>'
                            );
                            }).join('');
                            })
                            .catch(function (err) {
                            document.getElementById('people').innerHTML = '<li class="text-danger">' + err.message + '</li>';
                            });
}




