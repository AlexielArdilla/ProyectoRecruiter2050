package calculo;

public class Calculadora {

	public int[] convierteArrayAIntegers(String[] array) {

		int array_length = array.length;
		int array_de_enteros[] = new int[array_length];

		for (int i = 0; i < array_length; i++) {

			array_de_enteros[i] = Integer.parseInt(array[i]);

		}

		return array_de_enteros;
	}

	// media
	public double calculaPromedio(int[] array) {

		int sumatoria = 0;

		double promedio = 0;

		for (int i = 0; i < array.length; i++) {

			sumatoria += array[i];

		}

		promedio = (double) sumatoria / array.length;

		return promedio;
	}

	// el num del centro
	public int calculaLaMediana(int[] array) {

		array = burbujaOrdenar(array);
		int mitad = array.length/2;
		
		int mediana = 0;
		
		if(array.length == 0){
			
			return mediana;
			
		}else if(array.length==1){
			
			return array[0];
			
		}else if (array.length % 2 == 0) {

			mediana = (array[mitad-1]+array[mitad])/2;

		} else {

			mediana = array[mitad];
		}

		return mediana;
	}

	// el que se repite mas o moda mas chico
	public int calculaLaModa(int[] array) {

		int i, j = 0, n = array.length;
		int frecTemp, frecModa = 0, moda1 = -1;

		// ordenar de menor a mayor
		array = burbujaOrdenar(array);

		for (i = 0; i < n; i++) {
			frecTemp = 1;
			for (j = i + 1; j < n; j++) {
				if (array[i] == array[j])
					frecTemp++;
			}
			if (frecTemp > frecModa) {
				frecModa = frecTemp;
				moda1 = array[i];
			}
		}
		return moda1;

	}

	public int[] burbujaOrdenar(int[] array) {

		int temp = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {

				if (array[i] < array[j]) {

					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					
				}//fin if

			}//fin for interno

		}//fin for externo

		return array;
	}
	
	public Viabilidad arrayViable(String[] array_strings){
		
		int[] array = new Calculadora().convierteArrayAIntegers(array_strings);
		double promedio = new Calculadora().calculaPromedio(array);
		int mediana = new Calculadora().calculaLaMediana(array);
		int moda = new Calculadora().calculaLaModa(array);
		
		Viabilidad viabilidad = Viabilidad.No_APLICA;
		
		if(promedio < 4){
			
			viabilidad = Viabilidad.PESIMO;
			
			return viabilidad;
		}else if(promedio >= 4 && promedio < 7){
			
			viabilidad = Viabilidad.CASI_ACEPTABLE;
			
			return viabilidad;
		}else if(promedio == 7){
			
			viabilidad = Viabilidad.ACEPTABLE;
			
			return viabilidad;
		}else if(promedio == 8){
			
			viabilidad = Viabilidad.MUY_VIABLE;
				
		}
		
		if(moda >= 7){
			
			viabilidad = Viabilidad.SOBRESALIENTE;
			
		}
		
		if(mediana > 7){
			
			viabilidad = Viabilidad.OPTIMO;
			
		}
		
		
		return viabilidad;
	}
	
	public Viabilidad puntajeViable(int puntaje){
		
		Viabilidad viabilidad = Viabilidad.No_APLICA;
		
		if(puntaje < 4){
			
			return viabilidad = Viabilidad.PESIMO;
			
		}else if(puntaje >= 4 && puntaje < 6){
			
			return viabilidad = Viabilidad.CASI_ACEPTABLE;
			
		}else if(puntaje == 6){
			
			return viabilidad = Viabilidad.ACEPTABLE;
		}else if(puntaje > 6 && puntaje <= 8){
			
			return viabilidad = Viabilidad.MUY_VIABLE;
		}else if(puntaje == 9){
			
			return viabilidad = Viabilidad.SOBRESALIENTE;
		}else if(puntaje == 10){
			
			return viabilidad = Viabilidad.OPTIMO;
			
		}
		
		return viabilidad;
	}
	
	
}
