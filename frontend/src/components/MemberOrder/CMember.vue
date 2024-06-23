<template>
  <div>
    <div class="header">
      <h1>会员管理</h1>
    </div>
    <div class="container">
      <h2>会员列表</h2>
      <table>
        <tr>
          <th>ID</th>
          <th>姓名</th>
          <th>邮箱</th>
          <th>操作</th>
        </tr>
        <tr v-for="member in members" :key="member.id">
          <td>{{ member.id }}</td>
          <td>{{ member.name }}</td>
          <td>{{ member.email }}</td>
          <td>
            <a href="#" class="button">编辑</a>
            <a href="#" class="button">删除</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'CMember',
  data() {
    return {
      members: []
    };
  },
  mounted() {
    // 使用 AJAX 调用获取会员数据
    axios.get('/api/members')
        .then(response => {
          this.members = response.data;
        })
        .catch(error => console.error('获取会员数据时出错:', error));
  }
};
</script>

<style scoped>
/* 添加相应的样式 */
</style>
