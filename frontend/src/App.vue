<template>
  <div id="app">
    <Navbar />
    <div class="content">
      <Textarea label="备注" v-model="textareaValue" />
      <CustomTable />
    </div>
  </div>
</template>

<script>
import Navbar from './components/custom/CustomNavbar.vue';
import Textarea from './components/custom/CustomTextarea.vue';
import CustomTable from './components/custom/Table.vue';

export default {
  name: 'App',
  components: {
    Navbar,
    Textarea,
    CustomTable,
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
