<template>
  <div>
    <h1>Order Statistics</h1>
    <form @submit.prevent="getOrderStats">
      <label for="orderCount">Order Count Greater Than:</label>
      <input type="text" id="orderCount" v-model="orderCount"><br><br>
      <button type="button" @click="getOrderStats">Get Order Stats</button>
    </form>
    <div id="orderStatsResults">
      <ul>
        <li v-for="stat in orderStats" :key="stat.id">
          {{ stat.id }} - {{ stat.count }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'COrderStats',
  data() {
    return {
      orderCount: '',
      orderStats: []
    };
  },
  methods: {
    getOrderStats() {
      // 使用实际的 API 端点来获取订单统计数据
      fetch(`/api/orders/stats?count=${this.orderCount}`)
          .then(response => response.json())
          .then(data => {
            this.orderStats = data;
          })
          .catch(error => console.error('Error fetching order stats:', error));
    }
  }
};
</script>

<style scoped>
/* 添加对应的样式 */
</style>
