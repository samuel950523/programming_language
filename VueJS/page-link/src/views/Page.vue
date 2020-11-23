<template>
  <div class="about">
    <h1>Pagination ( Page-Link )</h1>
    <router-view/>
    <page-link/>
  </div>
</template>

<script>
// @ is an alias to /src
import PageLink from "@/components/PageLink.vue";

export default {
  name: "Page",
  components: {
    PageLink
  }
};
</script>
