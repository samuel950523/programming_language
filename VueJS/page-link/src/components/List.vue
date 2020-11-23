<template>
  <div>
    <div v-if="items.length">
      <table class="table table-bordered table-condensed">
        <colgroup>
          <col :style="{ width: '5%' }" />
          <col :style="{ width: '50%' }" />
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '25%' }" />
        </colgroup>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
        </tr>
        <list-row
          v-for="(item, index) in items"
          :key="`${index}_items`"
          :no="item.no"
          :title="item.title"
          :writer="item.writer"
          :regtime="item.regtime"
        />
      </table>
    </div>
    <div v-else>글이 없습니다.</div>

  </div>
</template>

<script>
import http from '@/util/http-common';
import ListRow from '@/components/Row.vue';
export default {
  name: 'list',
  components: {
    ListRow,
  },
  data: function() {
    return {
      items: [],
      pageLimit : 10,
      pageOffet : 0
    };
  },
  created() {

    this.initComponent();
  },
  watch: {
    '$route.query': function(){
      this.initComponent();
    }
  },
  methods: {
    initComponent(){
      http
        .get('/board/pagelink',{
            params: { limit: this.pageLimit, offset: `${this.$route.query.no - this.pageLimit}`}
          })
        .then(({ data }) => {
          this.items = data
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    }
  }
};
</script>

<style></style>
