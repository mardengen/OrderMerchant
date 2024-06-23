<script>
export default {
  name: 'CMember',
  data() {
    return {
      members: []
    };
  },
  mounted() {
    // AJAX call to fetch members
    fetch('/api/members')
        .then(response => response.json())
        .then(data => {
          this.members = data;
        })
        .catch(error => console.error('Error fetching members:', error));
  }
};
</script>
