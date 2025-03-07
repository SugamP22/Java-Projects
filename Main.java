package ejeEvaluable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solucion {
	public static Scanner sc = new Scanner(System.in);
	public static int[] celula = new int[10];
	public static int[] nuevoCelula = new int[10];

	public static void main(String[] args) {
		int opcion = 0;
		do {
			menu();
			try {
				opcion = sc.nextInt();
				switchMain(opcion);
			} catch (InputMismatchException e) {
				System.out.println("Entrada Invalido");
				sc.nextLine();
			}
		} while (opcion != 5);
		System.out.println("Gracias Por su Visita!!");
	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("::::: Modo Básico :::::::");
			inicializarPersonalizado();
			mostrarEstado();
			modoBasico();
			mostrarEstado();
			break;
		case 2:
			System.out.println("::::: Modo Aleatorio :::::::");
			inicializarAleatorio();
			mostrarEstado();
			modoAleatorio();
			mostrarEstado();
			break;
		case 3:
			System.out.println("::::: Modo Personalizado :::::::");
			inicializarPersonalizado();
			mostrarEstado();
			modoPersonalizado();
			mostrarEstado();
			break;
		case 4:
			System.out.println("::::: Modo Avanzado :::::::");
			inicializarPersonalizado();
			mostrarEstado();
			modoAvanzado();
			mostrarEstado();
			break;
		case 5:
			System.out.println("Saliendo....");
			break;
		default:
			System.out.println("Entrada Inválido");
			break;
		}

	}

	private static void modoAvanzado() {
		int turno = 10;
		for (int i = 1; i <= turno; i++) {
			System.out.printf("TURNO %d : ", i);
			for (int j = 0; j < celula.length; j++) {
				if (j != 0 && j != celula.length - 1) {
					nuevoCelula[j] = ((celula[j + 1] + celula[j - 1]) >= 1) ? 1 : 0;
				} else if (j == 0) {
					nuevoCelula[j] = (celula[j + 1] + celula[celula.length - 1] >= 1) ? 1 : 0;
				} else {
					nuevoCelula[j] = (celula[j - 1] + celula[0] >= 1) ? 1 : 0;
				}
			}
			for (int k = 0; k < nuevoCelula.length; k++) {
				System.out.print(nuevoCelula[k] + ((k != nuevoCelula.length - 1) ? " " : "\n"));
			}
			for (int a = 0; a < celula.length; a++) {
				celula[a] = nuevoCelula[a];
			}
		}
	}

	private static void modoPersonalizado() {
		System.out.println("¿Cuantos Turno quieres Jugar?");
		int turno = sc.nextInt();
		for (int i = 1; i <= turno; i++) {
			System.out.printf("TURNO %d : ", i);
			for (int j = 0; j < celula.length; j++) {
				if (j != 0 && j != celula.length - 1) {
					nuevoCelula[j] = ((celula[j + 1] + celula[j - 1]) >= 1) ? 1 : 0;
				} else if (j == 0) {
					nuevoCelula[j] = (celula[j + 1] == 1) ? 1 : 0;
				} else {
					nuevoCelula[j] = (celula[j - 1] == 1) ? 1 : 0;
				}
			}
			for (int k = 0; k < nuevoCelula.length; k++) {
				System.out.print(nuevoCelula[k] + ((k != nuevoCelula.length - 1) ? " " : "\n"));
			}
			for (int a = 0; a < celula.length; a++) {
				celula[a] = nuevoCelula[a];
			}
		}
	}

	private static void modoAleatorio() {
		int turno = 10;
		for (int i = 1; i <= turno; i++) {
			System.out.printf("TURNO %d : ", i);
			for (int j = 0; j < celula.length; j++) {
				if (j != 0 && j != celula.length - 1) {
					nuevoCelula[j] = ((celula[j + 1] + celula[j - 1]) >= 1) ? 1 : 0;
				} else if (j == 0) {
					nuevoCelula[j] = (celula[j + 1] == 1) ? 1 : 0;
				} else {
					nuevoCelula[j] = (celula[j - 1] == 1) ? 1 : 0;
				}
			}
			for (int k = 0; k < nuevoCelula.length; k++) {
				System.out.print(nuevoCelula[k] + ((k != nuevoCelula.length - 1) ? " " : "\n"));
			}
			for (int a = 0; a < celula.length; a++) {
				celula[a] = nuevoCelula[a];
			}
		}
	}

	private static void modoBasico() {
		int turno = 10;
		for (int i = 1; i <= turno; i++) {
			System.out.printf("TURNO %d : ", i);
			for (int j = 0; j < celula.length; j++) {
				if (j != 0 && j != celula.length - 1) {
					nuevoCelula[j] = ((celula[j + 1] + celula[j - 1]) >= 1) ? 1 : 0;
				} else if (j == 0) {
					nuevoCelula[j] = (celula[j + 1] == 1) ? 1 : 0;
				} else {
					nuevoCelula[j] = (celula[j - 1] == 1) ? 1 : 0;
				}
			}
			for (int k = 0; k < nuevoCelula.length; k++) {
				System.out.print(nuevoCelula[k] + ((k != nuevoCelula.length - 1) ? " " : "\n"));
			}
			for (int a = 0; a < celula.length; a++) {
				celula[a] = nuevoCelula[a];
			}
		}
	}

	public static void mostrarEstado() {
		System.out.printf("Estado : ");
		for (int k = 0; k < celula.length; k++) {
			System.out.print(celula[k] + ((k != celula.length - 1) ? " " : "\n"));
		}
	}

	private static void inicializarPersonalizado() {
		for (int i = 0; i < celula.length; i++) {
			boolean valor = false;
			while (!valor) {
				System.out.printf("Ingresa Valor para celula %d ------>", i + 1);
				try {
					int num = sc.nextInt();
					if (num < 0 || num > 1) {

						throw new IllegalArgumentException("Ingresa valor entre 1 y 0");
					}
					celula[i] = num;
					valor = true;

				} catch (InputMismatchException e) {
					System.out.println("Entrada Inválido!!");
					sc.nextLine();
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}

			}

		}
		System.out.println("Inicialización Completado Correctamente!!");
		System.out.println("***********************************************************");

	}

	private static void inicializarAleatorio() {
		for (int i = 0; i < celula.length; i++) {
			int num = (int) (Math.random() * 2);
			celula[i] = num;

		}
		System.out.println("Inicialización Completado Correctamente!!");
		System.out.println("*******************************************************");

	}

	private static void menu() {
		System.out.println(":::::: Menú Principal :::::::");
		System.out.println("1. Modo Básico");
		System.out.println("2. Modo Aleatorio");
		System.out.println("3. Modo Personalizado");
		System.out.println("4. Modo Avanzado");
		System.out.println("5. Salir");
		System.out.print("------->");

	}
}
