# Desencriptacion-AES
Uso de un algoritmo probabilistico para desencriptar una contrasena con sustitucion de 2 caracteres.

1. Generar llave con chars random (algunos nums y algunos letras), para comparacion al final.
2. Estructurar los grupos. 2 listas iniciales (lista de letras y lista de nums).
   Agruparlos en dos subgrupos de 15 letras y 6 nums cada uno, llenados con randoms de los subindices de las listas originales              correspondientes.
3. Realizar un tanteo sobre los subgrupos, de un 50% de sus combinaciones. 
4. Seleccionar el subgrupo con mayor porcentaje de exito y descartar el otro.
5. Generar nuevos subgrupos con los elementos del subgrupo "sobreviviente", preferiblemente entre 3 y 4 subgrupos. Cuantos mas grupos haya, menor sera el porcentaje de pruebas que se haran en cada grupo.
6. Generar porcentaje de exito por las pruebas a cada subgrupo. Seleccionar a la mitad de los subgrupos con mayor porcentaje de exito y descartar los "perdedores". 
7. Cuando los grupos resultantes esten determinados, obtener elementos en comun entre los subgrupos resultantes.

8.a. Si la cantidad de elementos de el subgrupo resultante (el mutante hecho de los MVPs de los subgrupos sobrevivientes) es menor a un total de 8, realizar pruebas exhaustivas sobre los elementos del subgrupo mutante.

8.b. Si la cantidad es mayor, dividir el grupo y volver a realizar los pasos de pruebas y descarte hasta obtener un subgrupo mutante cuya suma de elementos sea menor a 8.

9.a. Cruzar los dedos y esperar que alguna de esas combinaciones sea exitosa. Una de las combinaciones es la correcta y se ha descifrado la llave. Por lo tanto, la prueba fue exitosa.

9.b. Aceptar que en la vida no siempre se puede lograr lo que uno quiere y la combinacion correcta no esta en el subgrupo generado. La prueba no fue exitosa pero eso no evita que usted lo pueda ser en la vida. No hay que rendirse y hay que intentar de nuevo y mantener la esperanza de que la proxima si pegue.
10. Desencriptar el maldito texto.


