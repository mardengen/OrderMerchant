import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios';

// 设置 Axios 的基础 URL
axios.defaults.baseURL = 'http://localhost:8080'; // 或网关的 URL
createApp(App).mount('#app');
// 然后在组件中使用 axios 替代 fetch
// 示例在 COrder.vue 中：
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

