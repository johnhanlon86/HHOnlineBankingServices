// You must run the URI... 
// http://localhost:49000/api/bank/createpastcustomers ...to create the resources
// prior to running the index.html file 
// Allow Blocked content... if you see that warning in the browser




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

function viewDaryls83232AccountBalance() {
axios.get('http://localhost:49000/api/bank/getaccountbalance/0/83232/darylhowe').then(resp => {
    document.getElementById('people').innerHTML = 
            '<div> Balance: $' + resp.data + '</div>'  
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

function viewDarylsAccounts() {

axios.get('http://localhost:49000/api/bank/getcustomeraccounts/0/darylhowe')
                    .then(function (response) {
                    document.getElementById('people').innerHTML = response.data.map(function (account) {
                    return (
                            '<div class = "customerContainer">' +
                            '<div> Account Name: ' + account.accountName + '</div>' +
                            '<div> Account Number: ' + account.accountNumber + '</div>' + 
                            '<div> Sort Code: ' + account.sortCode + '</div>' +
                            '<div> Account Type: ' + account.accountType + '</div>' + 
                            '<div> Balance: ' + account.balance + '</div>'  +
                            '<div> -------------------------------- </div>' +
                            '</div>'
                            );
                            }).join('');
                            })
                            .catch(function (err) {
                            document.getElementById('people').innerHTML = '<li class="text-danger">' + err.message + '</li>';
                            });
}




function viewDarylsDetails() {

axios.get('http://localhost:49000/api/bank/getcustomerdetails/0/darylhowe')
                    .then(function (response) {
                        console.log(response);
                    document.getElementById('people').innerHTML = 
                            '<div> Account Name: ' + response.data.firstName + '</div>' + 
                            '<div> Second Name: ' + response.data.secondName + '</div>'+
                            '<div> Id Number: ' + response.data.customerID + '</div>'+
                            '<div> Email Address: ' + response.data.emailAddress + '</div>' +
                            '<div> Password: ' + response.data.password + '</div>' +                           
                                
                                response.data.accountsList.map(function (account) {
                    return (
                            '<div class = "customerContainer">' +
                            
                            '<div> Account Name: ' + account.accountName + '</div>' +
                            '<div> Account Number: ' + account.accountNumber + '</div>' + 
                            '<div> Sort Code: ' + account.sortCode + '</div>' +
                            '<div> Account Type: ' + account.accountType + '</div>' + 
                            '<div> Balance: ' + account.balance + '</div>'  +
                            
                            '<div> -------------------------------- </div>' +
                            '</div>' 
                            ) ;
                            }).join('');
                            })
                            .catch(function (err) {
                            document.getElementById('people').innerHTML = '<li class="text-danger">' + err.message + '</li>';
                            });
}


function viewAccountByNumber() {

var customerId = document.getElementById('customerId').value;
var accountNumber = document.getElementById('accountNumber').value;
var customerPassword = document.getElementById('customerPassword').value;


axios.get('http://localhost:49000/api/bank/getaccountdetails/' + customerId + '/' + accountNumber + '/' + customerPassword).then(resp => {
        console.log(resp);
        document.getElementById('people').innerHTML = 
            '<div> Account Name: ' + resp.data.accountName + '</div>' +
            '<div> Account Number: ' + resp.data.accountNumber + '</div>' + 
            '<div> Sort Code: ' + resp.data.sortCode + '</div>' +
            '<div> Account Type: ' + resp.data.accountType + '</div>' + 
            '<div> Balance: ' + resp.data.balance + '</div>'  
});
}

function viewDetails() {

var customerId = document.getElementById('customerId').value;
var customerPassword = document.getElementById('customerPassword').value;

axios.get('http://localhost:49000/api/bank/getcustomerdetails/' + customerId + '/' + customerPassword)
                    .then(function (response) {
                        console.log(response);
                    document.getElementById('people').innerHTML = 
                            '<div> Account Name: ' + response.data.firstName + '</div>' + 
                            '<div> Second Name: ' + response.data.secondName + '</div>'+
                            '<div> Id Number: ' + response.data.customerID + '</div>'+
                            '<div> Email Address: ' + response.data.emailAddress + '</div>' +
                            '<div> Password: ' + response.data.password + '</div>' +                           
                                
                                response.data.accountsList.map(function (account) {
                    return (
                            '<div class = "customerContainer">' +
                            
                            '<div> Account Name: ' + account.accountName + '</div>' +
                            '<div> Account Number: ' + account.accountNumber + '</div>' + 
                            '<div> Sort Code: ' + account.sortCode + '</div>' +
                            '<div> Account Type: ' + account.accountType + '</div>' + 
                            '<div> Balance: ' + account.balance + '</div>'  +
                            
                            '<div> -------------------------------- </div>' +
                            '</div>' 
                            ) ;
                            }).join('');
                            })
                            .catch(function (err) {
                            document.getElementById('people').innerHTML = '<li class="text-danger">' + err.message + '</li>';
                            });
}

function viewAccountHistory() {

var customerId = document.getElementById('customerId').value;
var accountNumber = document.getElementById('accountNumber').value;
var customerPassword = document.getElementById('customerPassword').value;

axios.get('http://localhost:49000/api/bank/getaccounthistory/'+ customerId + '/' + accountNumber + '/' + customerPassword)
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

function createCustomer (){
    console.log("hello");
    
    var newCustomerFirstName = document.getElementById('newCustomerFirstName').value;
    var newCustomerSecondName = document.getElementById('newCustomerSecondName').value;
    var newCustomerEmailAddress = document.getElementById('newCustomerEmailAddress').value;
    var newCustomerPassword = document.getElementById('newCustomerPassword').value;

    let response = axios.post('http://localhost:49000/api/bank/createnewcustomer/' + newCustomerFirstName +'/' + newCustomerSecondName + '/' + newCustomerEmailAddress + '/' + newCustomerPassword);
    console.log(response);
 }
 
 function openNewAccount(){
     
    var customerIdOpenAccount = document.getElementById('customerIdOpenAccount').value;
    var customerPasswordOpenAccount = document.getElementById('customerPasswordOpenAccount').value;
    var accountTypeOpenAccount = document.getElementById('accountTypeOpenAccount').value;
    var accountNumberOpenAccount = document.getElementById('accountNumberOpenAccount').value;
    var openingBalanceOpenAccount = document.getElementById('openingBalanceOpenAccount').value;
    var sortCodeOpenAccount = document.getElementById('sortCodeOpenAccount').value;

    let response = axios.put('http://localhost:49000/api/bank/opencustomeraccount/'+ customerIdOpenAccount +'/' + accountTypeOpenAccount + '/' + accountNumberOpenAccount + '/' + openingBalanceOpenAccount + '/' + sortCodeOpenAccount + '/'  + customerPasswordOpenAccount);
    console.log(response);
 }
 
  function deposit(){
     
    var customerIdDeposit = document.getElementById('customerIdDeposit').value;
    var customerPasswordDeposit = document.getElementById('customerPasswordDeposit').value;
    var accountNumberDeposit = document.getElementById('accountNumberDeposit').value;
    var depositAmountDeposit = document.getElementById('depositAmountDeposit').value;
    var descriptionDeposit = document.getElementById('descriptionDeposit').value;

    let response = axios.post('http://localhost:49000/api/bank/deposit/'+ customerIdDeposit +'/' + accountNumberDeposit + '/' + customerPasswordDeposit + '/' + depositAmountDeposit + '/' + descriptionDeposit);
    console.log(response);
 }