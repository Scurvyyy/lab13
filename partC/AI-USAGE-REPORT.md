# AI Usage Report

## 1. AI-г хэрхэн ашигласан бэ?
AI-г Spring Boot setup, CRUD API, testing, debugging болон documentation бичихэд ашигласан.

### AI хийсэн зүйлс

AI дараах зүйлсэд тусалсан:

- Spring Boot project structure санал болгох
- `Task`, `Priority` model class үүсгэх
- REST API endpoint бүхий `TaskController` үүсгэх
- `TaskService` болон `TaskRepository` код generation хийх
- CRUD API endpoint-ууд санал болгох
- H2 database configuration хийх
- JUnit болон Mockito unit test template бичих
- `.gitignore` болон Git commit format тайлбарлах
- Assignment structure болон documentation template гаргах

Өөрөө хийсэн зүйлс

Төслийн явцад олон асуудлыг гараар засаж шийдвэрлэсэн.
## Үүнд:


VS Code source root structure засах
Package mismatch issue шийдэх
Priority.java-г тусдаа file болгон зөв байрлуулах
Maven dependency error-ууд засах
Postman ашиглан API endpoint-ууд тестлэх
H2 database configuration-ийг ажиллуулах
.gitignore тохируулах
Git repository setup хийх
Folder structure assignment requirement-д тааруулах
Test failure debugging хийх

## 2. AI ямар давуу талтай байсан бэ?
- Boilerplate code хурдан үүсгэсэн
- JUnit test generation хийсэн
- Maven болон package issue debugging-д тусалсан

## 3. AI ямар алдаа гаргасан бэ?

### Hallucination Example 1
AI package structure-ийг буруу санал болгосон. Тэрнээс болж алдаа гарсан үүнийг багшийн өгсөн structure - тэй тулгаж харсан 

### Hallucination Example 2
Mockito matcher ашиглахдаа object equality issue гарсан. data base - ийн код ил гарж байсан public тохиргоотой share -лэх байсан тул энэ нь аюултай байсан энийг надад сануулсан .

## 4. Security талаар юу сурсан бэ?
Database password source code дотор hardcode хийх нь аюултай гэдгийг ойлгосон.

## 5. AI ашиглахгүйгээр хийж чадах байсан уу?
Хийж болох байх гэхдээ маш удаан бас цаг их орох шаардлагатай байсан. Мөн зөв бурууг шууд хараад мэдэхгүй асуух хүнгүй болохоор хэцүү байна байх

## 6. Юу сурсан бэ?
- Spring Boot architecture
- REST API
- JUnit testing
- AI-assisted debugging