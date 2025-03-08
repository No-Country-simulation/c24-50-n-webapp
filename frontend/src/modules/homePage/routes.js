import HomeDetails from './views/HomeDetails.vue';

export default [
    {
      path: '/user-home',
      name: 'HomePage',
      component: HomeDetails,
    },
    {
      path: '/home/details',
      name: 'HomeDetails',
      component: () => import('@/modules/homePage/views/HomeDetails.vue'),
    },
    {
      path: '/transferencia',
      name: 'transferencia',
      component: () => import('@/modules/homePage/views/TransferenciaView.vue'),
    }
  ];
  