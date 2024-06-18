<template>
  <table class="custom-table">
    <thead>
      <tr>
        <th>年限/金额</th>
        <th>30万</th>
        <th>70万</th>
        <th>100万</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>7年</td>
        <td>3,590元</td>
        <td>8,378元</td>
        <td>11,968元</td>
      </tr>
      <!-- 可以根据需要添加更多行 -->
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'CustomTable',
};
</script>

<style scoped>
.custom-table {
  width: 100%;
  border-collapse: collapse;
}

.custom-table th, .custom-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

.custom-table th {
  background-color: #00b33c;
  color: white;
}
</style>
