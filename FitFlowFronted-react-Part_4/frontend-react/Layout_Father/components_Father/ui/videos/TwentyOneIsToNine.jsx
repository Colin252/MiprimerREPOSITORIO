export default function TwentyOneIsToNine() {
  return (
    <div
      style={{ aspectRatio: "21 / 9" }}
      className="overflow-hidden rounded-lg"
    >
      <iframe
        src="https://www.youtube.com/embed/dQw4w9WgXcQ"
        title="YouTube video"
        frameBorder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowFullScreen
        className="w-full h-full"
      ></iframe>
    </div>
  );
}
