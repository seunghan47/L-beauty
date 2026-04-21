FROM node:20-slim AS build

WORKDIR /app

COPY package*.json ./

RUN npm ci

COPY . .

RUN npm run build

FROM nginx:alpine

RUN touch /var/run/nginx.pid && \
    chown -R nginx:nginx /var/run/nginx.pid /var/cache/nginx /var/log/nginx /etc/nginx/conf.d

COPY nginx.conf /etc/nginx/nginx.conf

COPY --from=build /app/build /usr/share/nginx/html

USER nginx

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
