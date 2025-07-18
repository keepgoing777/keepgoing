# 제이쿼리(jQuery)

- "적게 쓰고 더 많이"라는 슬로건을 가진 자바스크립트 라이브러리
- Ajax 호출 및 DOM 조작과 같은 자바스크립트의 복잡한 작업을 간단히 처리

## 제이쿼리 적용

- CDN(Content Delivery Network)을 통해 제이쿼리를 적용

```html
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
```

## 제이쿼리 구문

```js
$(selector).action();
```

- $ 기호 : jQuery를 정의하고 jQuery를 호출하여 jQuery를 사용
- selector : HTML 요소를 쿼리(또는 찾기)하는 역할
- action() : 선택된 요소가 행하는 동작을 명시

## 문서 준비 : document.ready()

```js
$(document).ready(function () {});
// or
$(function () {});
```

- window.addEventListener('DOMContentLoaded', function(){}); 와 유사한 기능
- 문서 로드가 완료되기 전에 jQuery 코드가 실행되지 않도록 하기 위한 것
