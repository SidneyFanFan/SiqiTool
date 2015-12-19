package com.siqi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.siqi.structure.Tuple;

/**
 * FileUtil is used for I/O of text files.
 * 
 * @author Sidney Fan
 *
 */
public class FileUtil {

	/**
	 * Read file as a string.
	 * 
	 * @param filePath
	 * @return a string file content
	 */
	public static String readFile(String filePath) {
		StringBuffer content = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while (br.ready()) {
				content.append(br.readLine());
				content.append("\n");
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	/**
	 * Read file to list of lines.
	 * 
	 * @param filePath
	 * @return a list of strings
	 */
	public static List<String> readFileByLine(String filePath) {
		List<String> content = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while (br.ready()) {
				content.add(br.readLine());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return content;
	}

	public static List<Tuple<String, String>> readFileByLineToTupleInString(String filePath) {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			String[] split;
			while (br.ready()) {
				line = br.readLine().replaceAll("\\(|\\)", "");
				split = line.split(", ");
				list.add(new Tuple<String, String>(split[0], split[1]));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public static List<Integer[]> readFileByLineToTupleInInteger(String filePath) {
		List<Integer[]> list = new ArrayList<Integer[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			String[] split;
			while (br.ready()) {
				line = br.readLine().replaceAll("\\(|\\)", "");
				split = line.split(", ");
				list.add(new Integer[] { Integer.valueOf(split[0]), Integer.valueOf(split[1]) });
			}
			br.close();
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> readFileByLineWithException(String filePath) throws IOException {
		ArrayList<String> content = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while (br.ready()) {
			content.add(br.readLine());
		}
		br.close();
		return content;
	}

	/**
	 * Export a string to file.
	 * 
	 * @param result
	 * @param filePath
	 */
	public static void export(String string, String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(string);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void exportStringArray(Object[] output, String filepath) {
		try {
			FileWriter fw = new FileWriter(filepath);
			for (int i = 0; i < output.length; i++) {
				fw.write(output[i].toString());
				fw.write("\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void exportListToFile(List<String> attrsList, String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath);
			for (String string : attrsList) {
				writer.write(string);
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void exportHashMapByline(HashMap<String, String> map, String exportPath) {
		try {
			FileWriter fw = new FileWriter(exportPath);
			for (Entry<String, String> en : map.entrySet()) {
				fw.write(en.getKey());
				fw.write("\n");
				fw.write(en.getValue());
				fw.write("\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void exportHashMapByEquation(HashMap<?, ?> map, String exportPath) {
		try {
			FileWriter fw = new FileWriter(exportPath);
			for (Entry<?, ?> en : map.entrySet()) {
				fw.write(en.toString());
				fw.write("\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void mergeDirectoryToSingleFile(String directoryPath, String exportPath) {
		File file = new File(directoryPath);
		try {
			FileWriter writer = new FileWriter(exportPath);
			if (file.isDirectory()) {
				File[] dirFile = file.listFiles();
				for (File f : dirFile) {
					if (f.isFile()) {
						BufferedReader reader = new BufferedReader(new FileReader(f));
						while (reader.ready()) {
							writer.write(reader.readLine());
							writer.write("\n");
						}
						reader.close();
					}
				}
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void mergeFiles(List<String> patternPathList, String mergedPath) {
		try {
			FileWriter writer = new FileWriter(mergedPath);
			for (String path : patternPathList) {
				File file = new File(path);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while (reader.ready()) {
					writer.write(reader.readLine());
					writer.write("\n");
				}
				reader.close();
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean hasFile(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
}
