<template>
  <div>
    <div className="header">
      <h1>下单</h1>
    </div>
    <div className="container">
      <h2>创建订单</h2>
      <form @submit.prevent="createOrder">
        <label htmlFor="productName">商品名称:</label><br>
        <input type="text" id="productName" v-model="order.productName"><br>
        <label htmlFor="amount">数量:</label><br>
        <input type="number" id="amount" v-model="order.amount"><br><br>
        <input type="submit" value="下单" className="button">
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'COrder',
  data() {
    return {
      order: {
        productName: '',
        amount: ''
      }
    };
  },
  methods: {
    createOrder() {
      axios.post('/api/orders', this.order)
          .then(response => {
            console.log('订单创建成功:', response.data);
          })
          .catch(error => {
            console.error('创建订单时出错:', error);
          });
    }
  }
};
</script>

<style scoped>
/* 添加相应的样式 */
</style>
