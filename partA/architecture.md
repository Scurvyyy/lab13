```mermaid
graph TD
    A[Client - React / Postman] --> B[Controller Layer]
    B --> C[Service Layer]
    C --> D[Repository Layer]
    D --> E[(MySQL Database)]

    
## Layers
- Controller → API endpoint
- Service → Business logic
- Repository → DB access
- Entity → Table mapping