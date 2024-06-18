<template>
  <form @submit.prevent="handleSubmit" class="custom-form">
    <slot></slot>
  </form>
</template>

<script>
export default {
  name: 'Form',
  methods: {
    handleSubmit() {
      this.$emit('submit');
    },
  },
};
</script>

<style scoped>
.custom-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}
</style>
