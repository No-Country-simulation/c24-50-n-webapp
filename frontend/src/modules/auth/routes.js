import ChangePassword from './views/ChangePassword.vue';
import ConfirmChange from './views/ConfirmChange.vue';
import RecoverPassword from './views/RecoverPassword.vue';
import RecoveryDoubleAuthenticationFactor from './views/RecoveryDoubleAuthenticationFactor.vue';
import Register from './views/Register.vue';
export default [
    {
      path: '/signup',
      name: 'signup',
      component: Register,
    },
    {
      path: '/recover',
      name: 'recover',
      component: RecoverPassword,
    },
    {
      path: '/recover-code',
      name: 'recoverCode',
      component: RecoveryDoubleAuthenticationFactor,
    },
    {
      path: '/change-password',
      name: 'changePassword',
      component: ChangePassword

    },
    {
      path: '/change-success',
      name: 'successChange',
      component: ConfirmChange
    }

  ];
  