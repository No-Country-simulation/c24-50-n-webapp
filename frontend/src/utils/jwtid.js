// utils/jwtHelper.js
export function decodeJWT(token) {
    const base64Url = token.split('.')[1]; // El payload está en la segunda parte
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/'); // Decodificar de base64url a base64
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
  
    return JSON.parse(jsonPayload); // Parseamos el JSON decodificado
  }

export const formatToUSD = (amount) => {
  return new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD'
  }).format(amount);
};