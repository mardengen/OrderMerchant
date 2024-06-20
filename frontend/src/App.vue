<template>
  <div id="app">
    <Navbar />
    <div class="content">
      <Textarea label="备注" v-model="textareaValue" />
      <CustomTable />
    </div>
    <CMember />
    <CMembers />
    <COrder />
    <COrderSearch />
    <COrderStats />
  </div>
</template>

<script>
import Navbar from './components/custom/CustomNavbar.vue';
import Textarea from './components/custom/CustomTextarea.vue';
import CustomTable from './components/custom/Table.vue';

import CMember from './components/MemberOrder/CMember.vue';
import CMembers from './components/MemberOrder/CMembers.vue';
import COrder from './components/MemberOrder/COrder.vue';
import COrderSearch from './components/MemberOrder/COrderSearch.vue';
import COrderStats from './components/MemberOrder/OrderStats.vue'; // 修改了这里的路径
export default {
  name: 'App',
  components: {
    Navbar,
    Textarea,
    CustomTable,
    CMember,
    CMembers,
    COrder,
    COrderSearch,
    COrderStats
  },
  data() {
    return {
      textareaValue: '',
    };
  },
};
</script>

<style>
.content {
  padding: 20px;
}
</style>
