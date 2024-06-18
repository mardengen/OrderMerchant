<template>
  <select :value="value" @change="$emit('update:value', $event.target.value)" class="custom-listbox">
    <option v-for="item in items" :key="item" :value="item">{{ item }}</option>
  </select>
</template>

<script>
export default {
  name: 'Listbox',
  props: {
    value: String,
    items: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.custom-listbox {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 100%;
}
</style>
