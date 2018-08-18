<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 70%;
    border: 1px solid #ddd;
}

th, td {
    text-align: left;
    padding: 16px;
}

tr:nth-child(even) {
    background-color: #f2f2f2
}

</style>
    <title>Transaction List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
    <h1>Transaction List</h1>
    
    <br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>Id</th>
          <th>ArrangementId</th>
          <th>ExternalId</th>
          <th>ExternalArrangementId</th>
          <th>ProductId</th>
          <th>Reference</th>
          <th>Description</th>
          <th>Category</th>
          <th>BookingDate</th>
          <th>ValueDate</th>
          <th>Amount</th>
          <th>Currency</th>
          <th>CreditDebitIndicator</th>
          <th>InstructedAmount</th>
          <th>InstructedCurrency</th>
          <th>CurrencyExchangeRate</th>
          <th>CounterPartyName</th>
          <th>CounterPartyAccountNumber</th>
          <th>Status</th>
        </tr>
        <c:forEach  items="${transactions}" var ="transaction">
        <tr>
          <td>${transaction.id}</td>
          <td>${transaction.arrangementId}</td>
          <td>${transaction.externalId}</td>
          <td>${transaction.externalArrangementId}</td>
          <td>${transaction.productId}</td>
          <td>${transaction.reference}</td>
          <td>${transaction.description}</td>
          <td>${transaction.category}</td>
          <td>${transaction.bookingDate}</td>
          <td>${transaction.valueDate}</td>
          <td>${transaction.amount}</td>
          <td>${transaction.currency}</td>
          <td>${transaction.creditDebitIndicator}</td>
          <td>${transaction.instructedAmount}</td>
          <td>${transaction.instructedCurrency}</td>
          <td>${transaction.currencyExchangeRate}</td>
          <td>${transaction.counterPartyName}</td>
          <td>${transaction.counterPartyAccountNumber}</td>
          <td>${transaction.status}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </body>
  
</html>