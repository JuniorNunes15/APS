package Atores;

import java.util.Date;

public class Locacao {

		
		private String codigoProduto;
		private int matriculaCliente;
		private int day;
		private int month;
		private int year;
		
		
		
		public double calculaMulta(int dayProdut, int day, int monthProdut, int month) {
			if(dayProdut > day && monthProdut >= month) {
				double taxa;
				taxa = (dayProdut - day) * 1 + (monthProdut - month) * 30; //vai ser paggo de multa 1 real por dia, e se passar 1 mes, paga 30 * o numero de meses + o numero de dias para entregar
				return taxa;
			}
			return 0;
		}



		public String getCodigoProduto() {
			return codigoProduto;
		}

		public void setCodigoProduto(String codigoProduto) {
			this.codigoProduto = codigoProduto;
		}

		public int getMatriculaCliente() {
			return matriculaCliente;
		}

		public void setMatriculaCliente(int matriculaCliente) {
			this.matriculaCliente = matriculaCliente;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

	
}
