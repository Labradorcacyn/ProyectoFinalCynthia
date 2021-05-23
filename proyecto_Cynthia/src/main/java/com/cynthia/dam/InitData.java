package com.cynthia.dam;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.cynthia.dam.model.Categoria;
import com.cynthia.dam.model.Producto;
import com.cynthia.dam.service.CategoriaService;
import com.cynthia.dam.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {

	private final ProductoService servicio;

	private final CategoriaService servicioCat;

	@PostConstruct
	public void init() {

		Categoria c1 = new Categoria("Oreja");
		Categoria c2 = new Categoria("Nariz");
		Categoria c3 = new Categoria("Labio");
		Categoria c4 = new Categoria("Corporal");

		servicioCat.save(c1);
		servicioCat.save(c2);
		servicioCat.save(c3);
		servicioCat.save(c4);

		Producto p1 = new Producto(c1, "CIRCULAR BARBELL", "Metalizado", 2.55,
				"https://www.crazy-factory.com/product_images/TBC/TBC12124RN-N_L-Piercings-Piercings-aros-Ball-closure-ring.JPG?dt=1617843813",
				LocalDateTime.now(),
				"Circular barbell de acero quirúrgico. Es ideal para el septum. pero también queda bien en la oreja. Y como está anodizado, podréis encontrarlo en diferentes colores.", 1.20);
		Producto p2 = new Producto(c4, "BANANA MODERNA", "Rosa", 3.15,
				"https://www.crazy-factory.com/product_images/CJ-BN0014/CJ-BN0014-1610AB_L-Piercings-Bananas-Banana-moderna.JPG?dt=1604643281",
				LocalDateTime.now(),
				"Fabricado en un grosor de 1.6 mm. Longitud de 10 mm. Disponible con diversos colores de gemas. Elije el que más te guste. En definitiva, fabricado con mimo y a un precio inigualable.", 1.60);
		Producto p3 = new Producto(c3, "SEPTUM CLICKER CON ISAGRA", "Plata", 5.55,
				"https://www.crazy-factory.com/product_images/SCSST14/SCSST14-16685AB-N_L-Piercings-Piercings-nariz-septums-Septum-clicker-con-isagra.JPG?dt=1617843785",
				LocalDateTime.now(),
				"Fabricado en dos grosores 1.2 mm. Disponible en dos longitudes diferentes: 6 mm y 8 mm. Acabado en diferentes colores. En definitiva, sensacional y a un precio inigualable.", 1.20);
		Producto p4 = new Producto(c2, "PIERCING DE NARIZ", "Plata", 0.89,
				"https://www.crazy-factory.com/product_images/NOBJ/NOBJ0865BZ-N_L-Piercings-Piercings-nariz-septums-Piercing-de-nariz.JPG?dt=1581586684",
				LocalDateTime.now(),
				"Estamos enamorados de nuestro piercing de nariz con bola de cristal. Es chulísimo. Tenemos brillantes en diferentes colores . Es pequeño pero elegante y fino.", 1.60);
		Producto p5 = new Producto(c4, "LONG OPEN STAPLES BARBELL", "Plata", 3.97,
				"https://www.crazy-factory.com/product_images/TOST/TOST16165-N_L-Piercings-Barbells-Long-Open-Staples-Barbell.JPG?dt=1540201650",
				LocalDateTime.now(),
				"Fabricado en dos grosores 1.2 mm y 1.6 mm. Las longitudes disponibles van desde 10 mm hasta 28 mm. Tú eliges el tamaño, fabricamos esta bola con diámetros desde 3 mm a 6 mm. En resumen, un producto fabricado con materiales de alta calidad no lo hace cualquiera.", 1.60);
		Producto p6 = new Producto(c1, "BARBELL", "Metalizado", 1.60,
				"https://www.crazy-factory.com/product_images/BLA/BLA16145RN_L-Piercings-Barbells-Barbell.JPG?dt=1588737850",
				LocalDateTime.of(2021, 03, 15, 15, 30),
				"Fabricado en un grosor de 1.2 mm. Diámetros desde 6 mm hasta 12 mm disponibles. Elegante pero atrevido en color blanco Ya lo tienes: tradicional pero moderno a la vez y a un precio asequible.", 1.20);
		Producto p7 = new Producto(c3, "ARO SEGMENTO CON ISAGRA", "Plata", 5.55,
				"https://www.crazy-factory.com/product_images/CJ-RGHSRC-OPL0001/CJ-RGHSRC-OPL0001-128WH_L-Piercings-Piercings-aros-Aro-segmento-con-isagra.JPG",
				LocalDateTime.of(2021, 02, 28, 10, 15),
				"Simple y llamativo a la vez. Barbell con bolas anodizadas en diferentes colores. Sóo hay que escoger el largo y a la cesta.", 1.20);
		Producto p8 = new Producto(c4, "BANANA CON DISEÑO FLOR", "Plata", 3.19,
				"https://www.crazy-factory.com/product_images/CJ-BN027-1/CJ-BN027-1-1610G_L-Piercings-Bananas-Banana-con-Dise%C3%B1o-flor.JPG?dt=1560241066",
				LocalDateTime.of(2021, 04, 14, 11, 45),
				"Disponible en grosor de 1.6 mm. 10 mm de longitud. En resumen, un producto guay no lo hace cualquiera.", 1.60);
		Producto p9 = new Producto(c4, "BANANA MODERNA", "Dorado", 4.19,
				"https://www.crazy-factory.com/product_images/CJ-GDBN0001/CJ-GDBN0001-1610CLAB_L-Piercings-Bananas-Banana-moderna.JPG?dt=1555898342",
				LocalDateTime.of(2021, 04, 17, 12, 30),
				"Fabricado en un grosor de 1.6 mm. Longitud de 10 mm. Fabricado con gemas de diversos colores para que puedas elegir el color que más te va. ¿Y qué mejor compañía que este piercing muy bonito?", 1.60);
		Producto p10 = new Producto(c4, "BANANA MODERNA", "Plata", 2.89,
				"https://www.crazy-factory.com/product_images/CJ-BN0043/CJ-BN0043-1610CR_L-Piercings-Bananas-Banana-moderna.JPG",
				LocalDateTime.of(2021, 02, 26, 10, 15),
				"Grosor de 1.6 mm. 10 mm de largo. Gemas en color cristal. En resumen, un producto dulce y salado a la vez no lo hace cualquiera.", 1.60);
		Producto p11 = new Producto(c2, "CONTINUOUS RING CON BRILLANTES", "Plata", 2.99,
				"https://www.crazy-factory.com/product_images/COBC7/COBC7-12CR-N_L-Piercings-Piercings-aros-Continuous-ring-con-brillantes.JPG?dt=1581586566",
				LocalDateTime.of(2021, 03, 16, 16, 30),
				"Disponible en grosor de 1.2 mm. Acabado en diferentes colores. Amor a primera vista: simple pero con estilo y acaba de conquistar tu corazón.", 1.20);
		Producto p12 = new Producto(c2, "ARO SEGMENTO CON BISAGRA", "Dorado", 5.59,
				"https://www.crazy-factory.com/product_images/TI-RS-HSR014/TI-RS-HSR014-1210CR_L-Piercings-Piercings-aros-Aro-segmento-con-bisagra.JPG",
				LocalDateTime.of(2021, 03, 12, 14, 45),
				"Fabricado en dos grosores 1.0 mm y 1.2 mm. Fabricado con alta precisión en diámetro de 8 mm y 10 mm. Elegante pero atrevido en color cristal En definitiva, fabricado con materiales de alta calidad y a un precio inigualable.", 1.20);
		Producto p13 = new Producto(c2, "LABRET CON ROSCA INTERIOR", "Plata", 5.98,
				"https://www.crazy-factory.com/product_images/TI-S-INLB0008/TI-S-INLB0008-168EM_L-Piercings-Labrets-Labret-con-rosca-interior.JPG?dt=1608514151",
				LocalDateTime.of(2021, 04, 17, 10, 55),
				"Disponible en 1.6 mm. Elige tu tamaño desde 5 mm a 12 mm de longitud. En resumen, un producto dulce y salado a la vez no lo hace cualquiera.", 1.60);
		Producto p14 = new Producto(c3, "BALL CLOSURE ARO EN FORMA DE PINCHO", "Plata", 0.89,
				"https://www.crazy-factory.com/product_images/BCW/BCW168_L-Piercings-Piercings-aros-Ball-closure-Aro-en-forma-de-pincho.JPG?dt=1582015110",
				LocalDateTime.of(2021, 04, 29, 13, 15),
				"Es simplemente chulísimo. Podrás llevarlo en la oreja o en el labio. ¡Demuestra lo duro que puedes ser!", 1.60);
		Producto p15 = new Producto(c3, "CIRCULAR BARBELL CON BOLAS Y BRILLANTES", "Plata", 3.97,
				"https://www.crazy-factory.com/product_images/MCBJT/MCBJT1283RO-N_L-Piercings-Circular-barbells-Circular-barbell-con-bolas-y-brillantes.JPG?dt=1581586672",
				LocalDateTime.of(2021, 03, 11, 10, 15),
				"Este circular barbell de acero quirúrgico con una barra de 1,2 mm de grosor está adornado con dos bolas tiffany, es decir, bolas con piedrecitas pequeñas, que podéis seleccionar en diferentes colores. Sientan muy bien.", 1.20);
		Producto p16 = new Producto(c1, "BALL CLOSURE RING CON DISEÑO CORAZÓN", "Plata", 2.63,
				"https://www.crazy-factory.com/product_images/BCMSC003/BCMSC003-168C-N_L-Piercings-Piercings-aros-Ball-closure-ring-con-Dise%C3%B1o-coraz%C3%B3n.JPG?dt=1581586466",
				LocalDateTime.of(2021, 03, 15, 12, 32),
				"Fabricado en dos grosores 1.2 mm y 1.6 mm. Selecciona el diámetro que te convenga, fabricado con diámetros desde 8 mm hasta 22 mm. 6 mm. ¿Y qué mejor compañía que este piercing delicado pero intenso?", 1.20);
	
		servicio.save(p1);
		servicio.save(p2);
		servicio.save(p3);
		servicio.save(p4);
		servicio.save(p5);
		servicio.save(p6);
		servicio.save(p7);
		servicio.save(p8);
		servicio.save(p9);
		servicio.save(p10);
		servicio.save(p11);
		servicio.save(p12);
		servicio.save(p13);
		servicio.save(p14);
		servicio.save(p15);
		servicio.save(p16);
	
	}
}
