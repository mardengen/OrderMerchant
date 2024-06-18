<template>
  <input
    type="text"
    :value="value"
    @input="$emit('update:value', $event.target.value)"
    class="custom-textbox"
  />
</template>

<script>
export default {
  name: 'Textbox',
  props: {
    value: String,
  },
};
</script>

<style scoped>
.custom-textbox {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 100%;
}
</style>
