<template>
  <div class="custom-scrollbar">
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'Scrollbar',
};
</script>

<style scoped>
.custom-scrollbar {
  max-height: 400px;
  overflow-y: auto;
}
</style>
