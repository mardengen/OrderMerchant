<template>
  <div class="custom-textarea-container">
    <label v-if="label" :for="id">{{ label }}</label>
    <textarea :id="id" :value="value" @input="$emit('update:value', $event.target.value)" class="custom-textarea"></textarea>
  </div>
</template>

<script>
export default {
  name: 'CustomNavbarTextarea',
  props: {
    value: String,
    label: String,
    id: String
  },
};
</script>

<style scoped>
.custom-textarea-container {
  margin-bottom: 20px;
}

.custom-textarea {
  width: 100%;
  height: 100px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: none;
}
</style>
