<template>

    <div id="app">
      <router-view name="NavBar"></router-view>
      <router-view></router-view>
      <router-view name="Footer"></router-view>
    </div>

</template> 

<script>
export default {
  name: "app"
};
</script>

<style>

@import url(https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css);

</style>
