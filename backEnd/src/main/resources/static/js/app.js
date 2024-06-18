function createOrder() {
    const memberId = document.getElementById('memberId').value;
    const productName = document.getElementById('productName').value;
    const purchaseDate = document.getElementById('purchaseDate').value;
    const amount = document.getElementById('amount').value;

    const order = {
        memberId,
        productName,
        purchaseDate,
        amount
    };

    fetch('/orders', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(order)
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('responseMessage').innerText = 'Order created successfully!';
        })
        .catch(error => console.error('Error:', error));
}

function searchOrders() {
    const orderNumber = document.getElementById('orderNumber').value;
    const productName = document.getElementById('productName').value;
    const orderDate = document.getElementById('orderDate').value;

    fetch(`/orders/search?orderNumber=${orderNumber}&productName=${productName}&orderDate=${orderDate}&page=0&size=10`)
        .then(response => response.json())
        .then(data => {
            const resultsDiv = document.getElementById('orderResults');
            resultsDiv.innerHTML = '<h2>Search Results</h2>';
            data.forEach(order => {
                const orderElement = document.createElement('div');
                orderElement.innerText = `Order ID: ${order.id}, Product Name: ${order.productName}, Order Date: ${order.purchaseDate}, Amount: ${order.amount}`;
                resultsDiv.appendChild(orderElement);
            });
        })
        .catch(error => console.error('Error:', error));
}

function getOrderStats() {
    const orderCount = document.getElementById('orderCount').value;

    fetch(`/orders/stats?orderCount=${orderCount}`)
        .then(response => response.json())
        .then(data => {
            const resultsDiv = document.getElementById('orderStatsResults');
            resultsDiv.innerHTML = '<h2>Order Stats</h2>';
            data.forEach(member => {
                const memberElement = document.createElement('div');
                memberElement.innerText = `Member ID: ${member.id}, Name: ${member.name}, Email: ${member.email}`;
                resultsDiv.appendChild(memberElement);
            });
        })
        .catch(error => console.error('Error:', error));
}
