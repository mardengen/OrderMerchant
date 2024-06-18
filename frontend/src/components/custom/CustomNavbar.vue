<template>
  <nav class="navbar">
    <div class="navbar-brand">
      <span class="navbar-title">某某人壽</span>
    </div>
  </nav>
<div>
    <ul class="navbar-menu">
      <li class="navbar-item"><a href="#">申请流程</a></li>
      <li class="navbar-item"><a href="#">常见问题</a></li>
      <li class="navbar-item"><a href="#">信贷试算</a></li>
      <li class="navbar-item"><a href="#">贷款知识</a></li>
      <li class="navbar-item"><button class="apply-button">立即申请</button></li>
    </ul>
</div>
</template>

<script>
export default {
  name: 'CustomNavbar',
};
</script>

<style scoped>
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #fff;
  padding: 10px 20px;
  border-bottom: 1px solid #eaeaea;
}

.navbar-brand {
  display: flex;
  align-items: center;
}

.navbar-logo {
  height: 40px;
  margin-right: 10px;
}

.navbar-title {
  font-size: 24px;
  font-weight: bold;
}

.navbar-menu {
  list-style: none;
  display: flex;
  margin: 0;
  padding: 0;
}

.navbar-item {
  margin-left: 20px;
}

.navbar-item a {
  text-decoration: none;
  color: #333;
  font-size: 16px;
}

.apply-button {
  background-color: #00b33c;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}

.apply-button:hover {
  background-color: #009933;
}
</style>
