<template>
  <div>
    <h1>Search Orders</h1>
    <form @submit.prevent="searchOrders">
      <label for="orderNumber">Order Number:</label>
      <input type="text" id="orderNumber" v-model="searchCriteria.orderNumber"><br><br>
      <label for="productName">Product Name:</label>
      <input type="text" id="productName" v-model="searchCriteria.productName"><br><br>
      <label for="orderDate">Order Date:</label>
      <input type="date" id="orderDate" v-model="searchCriteria.orderDate"><br><br>
      <button type="button" @click="searchOrders">Search Orders</button>
    </form>
    <div id="orderResults">
      <ul>
        <li v-for="order in orders" :key="order.id">
          {{ order.id }} - {{ order.productName }} - {{ order.orderDate }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'COrderSearch',
  data() {
    return {
      searchCriteria: {
        orderNumber: '',
        productName: '',
        orderDate: ''
      },
      orders: []
    };
  },
  methods: {
    searchOrders() {
      // 发送搜索条件到服务器并获取结果
      fetch('/api/orders/search', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.searchCriteria)
      })
          .then(response => response.json())
          .then(data => {
            this.orders = data;
          })
          .catch(error => console.error('Error searching orders:', error));
    }
  }
};
</script>

<style scoped>
/* 添加对应的样式 */
</style>
