/*Función del modal de borrar producto*/

$(document).ready(function() {
	$('#delete-modal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget);
		var data = button.data('id');

		var modal = $(this);

		var a = modal.find('.modal-body a')[0];
		a.href = a.href + data;

	});
});

/*
VALIDACION DE CAMPOS REQUERIDOS JAVASCRIPT

No me funciona correctamente en el formulario.

let nombre = document.getElementById('nombre');
let color = document.getElementById('color');
let error = document.getElementById('error');
error.style.color = 'red';

var form = document.getElementById('productoForm');
form.addEventListener('submit', function(e){
	e.preventDefault();
	var mensajesError = [];
	if(nombre.value === null || nombre.value === ''){
		mensajesError.push('Ingresa el nombre del producto');
	}
	
	error.innerHTML = mensajesError.join(', ');
});*/

/*Menu toggle */
(function($) {
	"use strict"

	
	$('.menu-toggle > a').on('click', function (e) {
		e.preventDefault();
		$('#responsive-nav').toggleClass('active');
	})

	
	$('.cart-dropdown').on('click', function (e) {
		e.stopPropagation();
	});

	/*Funciones Slick*/
	$('.products-slick').each(function() {
		var $this = $(this),
				$nav = $this.attr('data-nav');

		$this.slick({
			slidesToShow: 4,
			slidesToScroll: 1,
			autoplay: true,
			infinite: true,
			speed: 300,
			dots: false,
			arrows: true,
			appendArrows: $nav ? $nav : false,
			responsive: [{
	        breakpoint: 991,
	        settings: {
	          slidesToShow: 2,
	          slidesToScroll: 1,
	        }
	      },
	      {
	        breakpoint: 480,
	        settings: {
	          slidesToShow: 1,
	          slidesToScroll: 1,
	        }
	      },
	    ]
		});
	});
	
	$('.products-widget-slick').each(function() {
		var $this = $(this),
				$nav = $this.attr('data-nav');

		$this.slick({
			infinite: true,
			autoplay: true,
			speed: 300,
			dots: false,
			arrows: true,
			appendArrows: $nav ? $nav : false,
		});
	});
	
	
	$('#product-main-img').slick({
    infinite: true,
    speed: 300,
    dots: false,
    arrows: true,
    fade: true,
    asNavFor: '#product-imgs',
  });


  $('#product-imgs').slick({
    slidesToShow: 3,
    slidesToScroll: 1,
    arrows: true,
    centerMode: true,
    focusOnSelect: true,
		centerPadding: 0,
		vertical: true,
    asNavFor: '#product-main-img',
		responsive: [{
        breakpoint: 991,
        settings: {
					vertical: false,
					arrows: false,
					dots: true,
        }
      },
    ]
  });


	/*Comprobación numero Formulario*/
	$('.input-number').each(function() {
		var $this = $(this),
		$input = $this.find('input[type="number"]'),
		up = $this.find('.qty-up'),
		down = $this.find('.qty-down');

		down.on('click', function () {
			var value = parseInt($input.val()) - 1;
			value = value < 1 ? 1 : value;
			$input.val(value);
			$input.change();
			updatePriceSlider($this , value)
		})

		up.on('click', function () {
			var value = parseInt($input.val()) + 1;
			$input.val(value);
			$input.change();
			updatePriceSlider($this , value)
		})
	});

	var priceInputMax = document.getElementById('price-max'),
			priceInputMin = document.getElementById('price-min');

	priceInputMax.addEventListener('change', function(){
		updatePriceSlider($(this).parent() , this.value)
	});

	priceInputMin.addEventListener('change', function(){
		updatePriceSlider($(this).parent() , this.value)
	});

})(jQuery);
